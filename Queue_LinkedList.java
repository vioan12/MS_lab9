/**
 * Created by ioan on 1/3/18.
 */
public class Queue_LinkedList<E>
{
    private Queue_LinkedList<E> next;
    private E value;

    Queue_LinkedList()
    {
        value=null;
        next=null;
    }
    public Queue_LinkedList<E> Next()
    {
        return next;
    }
    public E Value()
    {
        return value;
    }
    public int Size()
    {
        int nr = 0;
        Queue_LinkedList<E> p;
        p = this;
        if(p.value!=null) {
            do {
                nr++;
                p = p.Next();
            } while (p != null);
        }
        return nr;
    }
    public void Add(E value)
    {
        Queue_LinkedList<E> p;
        p = this;
        int size = p.Size();
        if (size > 1) {
            do {
                p = p.Next();
            } while (p.Next() != null);
            p.next = new Queue_LinkedList<E>();
            p = p.next;
            p.value = value;
        }
        if (size == 1) {
            p.next = new Queue_LinkedList<E>();
            p = p.next;
            p.value = value;
        }
        if (size == 0) {
            p.value = value;
        }
    }
    public Queue_LinkedList<E> HeadDowngrade()
    {
        Queue_LinkedList<E> p,q;
        p=this;
        if(p.next!=null) {
            q = p.next;
            p.next = q.next;
            q.next = p;
            return q;
        }
        return p;
    }
}
