import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student> {
	
	private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }    
    /**
     * 양수가 리턴 되는 경우 현재 Object가 앞
     * 음수가 리턴 되는 경우 현재 Object가 뒤
     * 0이 리턴되는 경우 동일 값으로 간주하고 입력순서 유지
     */
    @Override
    public int compareTo(Student o) {
        int result = this.getName().compareTo(o.getName());
        if(result == 0) {
            result = this.getAge() - o.getAge();
        }
        return result;
        // 기존의 정렬 기준을 바탕으로 나이로 비교한다.
    }
    
	public static void main(String[] args) {
		 Student s1 = new Student("손흥민", 29); 
		 Student s2 = new Student("박지성", 31);
		 Student s3 = new Student("박지성", 30);
		 Student[] arr = new Student[]{s1, s2, s3};
		    
		 
		 //Comparable
		 Arrays.sort(arr);
		    
		 for(Student s : arr) {
	       System.out.println(s.getName() + " " + s.getAge());
	    }
		 
		 System.out.println();
		 
		 //Comparator
		 //Student 클래스에서 새로운 정렬 기준을 활용하기 위해 Comparator를 사용한다.
		 Arrays.sort(arr,new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge()-o2.getAge();
			}
		 });
		 
		 for(Student s : arr) {
		       System.out.println(s.getName() + " " + s.getAge());
		    }
	}
}
