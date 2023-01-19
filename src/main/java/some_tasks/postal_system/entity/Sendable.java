package some_tasks.postal_system.entity;


/*
Interface: An entity that can be mailed.
From such an entity, you can get from whom and to whom the letter is sent.
*/
public interface Sendable {
    String getFrom();
    String getTo();
}
