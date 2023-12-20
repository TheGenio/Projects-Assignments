package LAB01;

public class TSK2_STUDENT {

    public static void main(String[] args){

        student[] students = new student[10];
        for(int i = 0; i < 10; i++){
            students[i] = Math.random() > 0.5 ? new Undergraduate("3123213", (int)(Math.random()*5)) : new graduate("201031",(int)(Math.random()*4));
            System.out.println(
                    students[i] instanceof graduate ? "Graduate " + students[i].displayStudent() : "UnderGraduate " + students[i].displayStudent());
        }



    }


    abstract static class student{
        String ID;
        int gpa;
        String status;

        student(){
            this.ID = null;
            this.gpa = 0;
            this.status = null;
        }

        student(String ID, int gpa){
            this.ID = ID;
            this.gpa = gpa;
        }

        public abstract String getStatus();

        final String displayStudent(){
            return "ID: "+ ID + " gpa: "+ gpa+ " status: "+ getStatus();
        }
    }

    static class Undergraduate extends student{

        Undergraduate(String ID, int gpa){
            super(ID, gpa);
        }
        @Override
        public String getStatus() {
            return super.gpa >= 3.0 ? "Honor" : super.gpa >= 2 ? "good" : "probation";
        }

    }

    static class graduate extends student {

        graduate(String ID, int gpa){
            super(ID, gpa);
        }
        @Override
        public String getStatus() {
            return super.gpa >= 3.0 ? "good" : "probation";
        }
    }
}
