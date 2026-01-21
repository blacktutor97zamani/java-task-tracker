public class school {
    String name;
    int numOfCourses;
    int year;

    school(String name, int numOfCourses, int year){
        this.name = name;
        this.numOfCourses= numOfCourses;
        this.year = year;
    }
    public static void main(String[] a){
        school student1 = new school("AIT", 15, 2025);

    }
}
