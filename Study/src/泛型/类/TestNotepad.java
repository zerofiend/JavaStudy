package 泛型.类;

public class TestNotepad {
    public static void main(String[] args) {
        Notepad<Integer,String> notepad = new Notepad<>(1,"hello world");
        System.out.println(notepad.getKey());
        System.out.println(notepad.getValue());
    }
}
