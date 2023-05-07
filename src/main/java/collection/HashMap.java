package collection;

import java.util.Map;

public class HashMap {

    public static void main(String[] args) {

        Map<Student, String> map = new java.util.HashMap<>();
        Student student = new Student("tom", 20);
        map.put(student, "tom");

        System.out.println(map);
    }

    static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Student() {
        }

        public Object readResolve() {
            return new Student();
        }
    }
}
