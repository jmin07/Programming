package bounded;

// 버퍼 역할을 하는 큐의 인터페이스
public interface BoundedQueue {

    void put(String data);  // 버퍼에 데이터를 보관

    String take();  // 버퍼에 보관된 값을 가져간다.

}
