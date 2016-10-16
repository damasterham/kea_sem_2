package Observer;//

//Created by DaMasterHam on 06-10-2016.
//
public class LateObserver extends Observer
{
    private int last;
    private boolean hasObserved;

    public LateObserver(Subject subject)
    {
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update()
    {
        if (!hasObserved)
        {
            last = subject.getState();
            hasObserved = true;
        }
        else
        {
            System.out.println("Oh wait was it: " + last);
            last = subject.getState();
        }

    }
}
