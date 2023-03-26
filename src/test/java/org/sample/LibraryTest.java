package org.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LibraryTest {

    Library library;

    @BeforeEach
    public void runBeforeEachTest(){
    library = new Library();
    }

    @Test
    public void default_Number_Of_Books_In_Library_Should_be_One_Initially() {
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void adding_to_catalagoue_should_increase_booke_count_of_library() {
        Book newBook = library.addToCatalogue("Discovery of India", "Jawaharlal Nehru", 432, 11.99);
        int totalBooks = library.getBooks().size();
        //assertThat from hamcrest is more effective in checking equals to
        //Assertion 1 - Verifying new bookd id is 2
        //Assertion 2 - Verifying total books in library now is 2
        //Assertion 3 - Verifying if the library contains newly added book
        assertEquals(2, newBook.getId());
        assertThat(totalBooks, equalTo(2));
        assertThat(library.getBooks(), hasItem(newBook));
    }

    //for findBookByName method in library class, we have 2 test cases and there are 2 returns/outputs .If condition is a success test case and else it is failure test case@Test

    @Test
    public void find_book_by_name_called_with_available_book_name_should_return_book_object() {
        Book book=library.findBookByName("The God Of Small Things");
        assertNotNull(book);
    }

    @Test
    public void find_book_by_name_called_with_unavailable_book_name_should_return_null() {
        Book book=library.findBookByName("INVALID NAME");
        assertNull(book);
    }

    @Test
    public void calculateBookRent_should_return_2_dollars_if_number_of_days_is_4() {
        RentedBook rentedBook=Mockito.mock(RentedBook.class);
        LocalDate fourDaysBeforeToday = LocalDate.now().minusDays(4) ;
        Mockito.when(rentedBook.getRentedDate()).thenReturn(fourDaysBeforeToday);
        Double bookRent=library.calculateBookRent(rentedBook);
        // Assertion 1 - Verify if book rent is 2
        assertThat(bookRent,equalTo(Double.valueOf(2)));
        // Assertion 2 - Verify if getRentedDate is called inside calculateBookRent
        Mockito.verify(rentedBook).getRentedDate();
    }

    @Test
    public void calculateBookRent_should_return_6_dollars_if_number_of_days_is_6() {
        RentedBook rentedBook=Mockito.mock(RentedBook.class);
        LocalDate sixDaysBeforeToday = LocalDate.now().minusDays(6) ;
        Mockito.when(rentedBook.getRentedDate()).thenReturn(sixDaysBeforeToday);
        Double bookRent=library.calculateBookRent(rentedBook);
        // Assertion 1 - Verify if bookrent is 2
        assertThat(bookRent,equalTo(Double.valueOf(6)));
        // Assertion 2 - Verify if getRentedDate is called inside calculateBookRent
        Mockito.verify(rentedBook).getRentedDate();
    }
}