public class Library {
    
    // ATTRIBUTES LIST: create lists to be used to generate the catalog
    ArrayList<Book> catalog = new ArrayList<Book>(20);
    ArrayList<Integer> possibleYearsOfPublication = new ArrayList<Integer>(40);
    ArrayList<String> possibleSubjects = new ArrayList<String>(5);
    ArrayList<Integer> countSubjects = new ArrayList<Integer>(5);
    
    // CONSTRUCTOR:
    public Library() {

        // adds books to the catalog. only gives titles "Book <number>"
        for(int i=0; i<20; i++) {
            Book book = new Book();
            book.setTitle("Book " + i);
            catalog.add(book);
        }

        // create a list of possible years of publication to keep track
        for(int i=1980; i<=2019; i++) {
            possibleYearsOfPublication.add(i);
        }

        // add possible subjects to the list
        possibleSubjects.add("Programming");
        possibleSubjects.add("Data Structures");
        possibleSubjects.add("Algorithms");
        possibleSubjects.add("Operating Systems");
        possibleSubjects.add("Gaming");

        // set all subject counts to 0
        while(countSubjects.getSize() < 5) {
            countSubjects.add(0);
        }


        randomizeYearOfPublication();
        randomizeSubject();
        randomizeReviewRating();

    }


    // METHODS TO RANDOMIZE BOOKS
    public void randomizeYearOfPublication() {
        for(int i=0; i<catalog.getSize(); i++) {
            // select a random year and eliminate it as an option.
            int random = (int) (40*Math.random());
            int year = possibleYearsOfPublication.get(random);
            possibleYearsOfPublication.remove(random);

            // get a book, set its year, and add it back to the list.
            Book currentBook = catalog.get(i);
            currentBook.setYearOfPublication(year);
            catalog.set(i, currentBook);
        }
    }
    
    public void randomizeNumPages() {
        for(int i=0; i<catalog.getSize(); i++) {
            int pageCount = (int) (50 + 951*Math.random());
            Book currentBook = catalog.get(i);
            currentBook.setNumPages(pageCount);
            catalog.set(i, currentBook);
        }
    }

    public void randomizeSubject() {
        for(int i=0; i<catalog.getSize(); i++) {
            // select a subject that has less than 5 books.
            int random = (int) (5*Math.random());
            while(countSubjects.get(random) >= 5) {
                random = (int) (5*Math.random());
            }
            // increment the count of the chosen subject.
            Integer count = countSubjects.get(random);
            count++;
            countSubjects.set(random, count);

            // get a book, set its subject, and add it back to the list.
            Book currentBook = catalog.get(i);
            currentBook.setSubject(possibleSubjects.get(random));
            catalog.set(i, currentBook);
        }
    }

    public void randomizeReviewRating() {
        for(int i=0; i<catalog.getSize(); i++) {
            float rating = (float) (0.1 + 9.9*Math.random());
            Book currentBook = catalog.get(i);
            currentBook.setReviewRating(rating);
            catalog.set(i, currentBook);
        }
    }

    // TOSTRING METHOD
    public String toString() {
        String output = "LIBRARY CATALOG:";

        for(int i=0; i<catalog.getSize(); i++) {
            Book book = catalog.get(i);
            output += "\n";
            output += book.title + ": " +
            book.yearOfPublication + ", " +
            book.numPages + ", " +
            book.subject + ", " +
            book.reviewRating;
        }

        return output;
    }
}
