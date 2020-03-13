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
     * ����� ���� �Ǵ� ��� ���� Object�� ��
     * ������ ���� �Ǵ� ��� ���� Object�� ��
     * 0�� ���ϵǴ� ��� ���� ������ �����ϰ� �Է¼��� ����
     */
    @Override
    public int compareTo(Student o) {
        int result = this.getName().compareTo(o.getName());
        if(result == 0) {
            result = this.getAge() - o.getAge();
        }
        return result;
        // ������ ���� ������ �������� ���̷� ���Ѵ�.
    }
    
	public static void main(String[] args) {
		 Student s1 = new Student("�����", 29); 
		 Student s2 = new Student("������", 31);
		 Student s3 = new Student("������", 30);
		 Student[] arr = new Student[]{s1, s2, s3};
		    
		 
		 //Comparable
		 Arrays.sort(arr);
		    
		 for(Student s : arr) {
	       System.out.println(s.getName() + " " + s.getAge());
	    }
		 
		 System.out.println();
		 
		 //Comparator
		 //Student Ŭ�������� ���ο� ���� ������ Ȱ���ϱ� ���� Comparator�� ����Ѵ�.
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
