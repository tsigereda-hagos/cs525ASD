package main;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemComponent{
    protected String name;
    List<FileSystemComponent> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<FileSystemComponent>();
    }

    public void print() {
        System.out.println("-- dir " + name + " size=" + getSizeInBytes() + " bytes");
        for (FileSystemComponent c : children) {
            c.print();
        }
    }

    @Override
    public void addComponent(FileSystemComponent c) {
        this.children.add(c);
    }

    @Override
    public void removeComponent(FileSystemComponent c) {
        this.children.remove(c);
    }

    @Override
    public FileSystemComponent getChild(int i) {
        return this.children.get(i);
    }

    @Override
    public int getSizeInBytes() {
        int size = 0;
        for (FileSystemComponent c : children) {
            size += c.getSizeInBytes();
        }

        return size;
    }
}
