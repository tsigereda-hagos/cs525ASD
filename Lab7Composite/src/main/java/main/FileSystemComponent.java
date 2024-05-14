package main;

public abstract class FileSystemComponent {
    public void addComponent(FileSystemComponent c) {
        throw new UnsupportedOperationException("This object does not support this method.");
    }

    public void removeComponent(FileSystemComponent c) {
        throw new UnsupportedOperationException("This object does not support this method.");
    }

    public FileSystemComponent getChild(int i) {
        throw new UnsupportedOperationException("This object does not support this method.");
    }

    public abstract int getSizeInBytes();

    public abstract void print();
}
