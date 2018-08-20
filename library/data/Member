package library.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//hold information about the people in library list.
public class Member {
	/* Property allows us to automatically be notified, because when changes
	   are made to one object, then it is automatically reflected in another object.
	   StringProperty is the abstract  */
	private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty pesel;
    private final StringProperty books;
    
    public Member() {
    	this(null, null, null, null);
    }
    
    public Member(String firstName, String lastName, String pesel, String books) {
    	//we use SimpleStringProperty as the concrete implementation
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.pesel = new SimpleStringProperty(pesel);
        this.books = new SimpleStringProperty(books);
    }

    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
    public StringProperty firstNameProperty() {
        return firstName;
    }
    //////***************
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    public StringProperty lastNameProperty() {
        return lastName;
    }
    //////***************
    public String getPesel() {
        return pesel.get();
    }
    public void setPesel(String pesel) {
        this.pesel.set(pesel);
    }
    public StringProperty lastPeselProperty() {
        return pesel;
    }
    //////***************
    public String getBooks() {
        return books.get();
    }
    public void setBooks(String books) {
        this.books.set(books);
    }
    public StringProperty lastBooksProperty() {
        return books;
    }
}
