package main;

public class Link extends FileSystemComponent{
    FileSystemComponent target;

    public Link(FileSystemComponent target) {
        super();
        this.target = target;
    }

    @Override
    public int getSizeInBytes() {
        return target.getSizeInBytes();
    }

    @Override
    public void print() {
        System.out.print("[Virtual link] ");
        target.print();
    }
}
