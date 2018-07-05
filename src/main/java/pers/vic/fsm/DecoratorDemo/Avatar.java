package pers.vic.fsm.DecoratorDemo;

/**
 * Create By Vic Xu on 7/5/2018
 */
public class Avatar extends Intelligentor {

    private Intelligentor intelligentor;

    public Avatar(Intelligentor intelligentor) {
        this.intelligentor = intelligentor;
    }

    @Override
    public void walk() {
        System.out.println("other before work.....");
        intelligentor.walk();
        System.out.println("other after");
    }
}
