package edu.mum.cs.cs525.labs.skeleton;

public interface Command {
    void execute();
    void undo();
    Account getAccount();
}
