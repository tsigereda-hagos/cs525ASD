package main;

public class Drive {
    protected String name;
    protected FileSystemComponent rootDir;

    public Drive(String name, FileSystemComponent rootDir) {
        this.name = name;
        this.rootDir = rootDir;
    }

    public int computeSize() {
        return rootDir.getSizeInBytes();
    }

    public void print() {
        System.out.println("- drive " + name);
        rootDir.print();
    }
}
