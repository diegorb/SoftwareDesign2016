package mx.iteso;

/**
 * Created by felipe on 9/1/16.
 */
public interface Foo {

    String HELLO_WORLD = "Hello World";
    String ANY_NEW_TOPICS = "Are there any new topics?";

    String greet();
    String question(String question);
    String questionStrictly(String question) throws InvalidQuestion;
}