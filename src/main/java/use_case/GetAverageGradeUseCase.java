package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();
        String[] members = team.getMembers();
        int grade_sum = 0;
        int num_grades = 0;
        for (String member : members) {
            grade_sum += gradeDB.getGrade(member, course).getGrade();
            num_grades += 1;
        }
        return (float) grade_sum / num_grades;
    }
}
