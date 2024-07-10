package TreeSetPractice;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int chinese;
    private int math;
    private int english;

    public Student() {
    }

    public Student(int age, int chinese, int english, int math, String name) {
        this.age = age;
        this.chinese = chinese;
        this.english = english;
        this.math = math;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Student{name: " + name + ", age: " + age + ", chinese: " + chinese + ", math: " + math + ", english: " + english + "}\n";
    }

    @Override
    public int compareTo(Student o) {
        int thisSum = this.getChinese() + this.getMath() + this.getEnglish();
        int oSum = o.getChinese() + o.getMath() + o.getMath();

        int i = thisSum - oSum;

        i = i == 0 ? this.getChinese() - o.getChinese() : i;
        i = i == 0 ? this.getMath() - o.getMath() : i;
        i = i == 0 ? this.getAge() - o.getAge() : i;
        i = i == 0 ? this.getName().compareTo(o.getName()) : i;

        return i;
    }
}
