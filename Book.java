public class Book {
    
    // ATTRIBUTES
    String title;
    String subject;
    int yearOfPublication;
    int numPages;
    float reviewRating;

    // CONSTRUCTOR
    public Book() {
        // empty constructor. will specify attributes in mutator methods.
    }

    // MUTATOR METHODS
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setSubject(String newSubject) {
        this.subject = newSubject;
    }

    public void setYearOfPublication(int newYearOfPublication) {
        this.yearOfPublication = newYearOfPublication;
    }

    public void setNumPages(int newNumPages) {
        this.numPages = newNumPages;
    }

    public void set(float newReviewRating) {
        this.reviewRating = newReviewRating;
    }
}
