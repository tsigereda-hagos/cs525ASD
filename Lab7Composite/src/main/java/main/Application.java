package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		FileSystemComponent rootDir = new Directory("root");

		FileSystemComponent appdir = new Directory("applications");
		FileSystemComponent datadir = new Directory("my data");
		FileSystemComponent coursedir = new Directory("cs525");
		FileSystemComponent excelfile = new File("msexcel.exe", 2353256);
		FileSystemComponent wordfile = new File("msword.exe", 3363858);
		FileSystemComponent studentsfile = new File("students.doc", 34252);

		FileSystemComponent excelLink = new Link(excelfile);

		rootDir.addComponent(appdir);
		rootDir.addComponent(datadir);
		datadir.addComponent(coursedir);
		appdir.addComponent(excelfile);
		appdir.addComponent(wordfile);
		coursedir.addComponent(studentsfile);
		coursedir.addComponent(excelLink);

		Drive drive = new Drive("MyDrive", rootDir);

		drive.print();
	}

}
