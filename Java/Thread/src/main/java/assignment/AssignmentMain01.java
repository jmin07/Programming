package assignment;

public class AssignmentMain01 {

    // 정적 중첩 클래스로 해도 된다.
    public static void main(String[] args) {
        Assignment01 thread = new Assignment01();
        thread.start(); // 부모 클래스의 메서드이다.
    }
}
