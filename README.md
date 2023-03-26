This project is a sample project which demoed how to write test cases for a library application

one method can have multiple test cases
One test case should be dedicated to one particular scenario that occurs in a method. 
There could be multiple assertions in a single test case. example - adding_to_catalagoue_should_increase_booke_count_of_library

Annotations :
@Test - denotes a test case 
@BeforeEach - The method annotated under this gets executed before each and every test method.
@BeforeAll - The method annotated under this gets executed before all the test methods and is executed only once at the start.
@AfterEach - The method annotated under this gets executed after each and every test method.
@AfterAll - The method annotated under this gets executed after all the test methods and is executed only once at the end.
@ExtendWith - used on our test class which enables us to usmocking methods
@Mock - It is used to create and inject mocked instances.
@Spy - It is used to create a real object and spy on the real object.
@InjectMocks - It is used to create an object of a class and insert its dependencies.

Rules for annotations:
@BeforeAll and @AfterAll should always be static methods. Else its compile error

MOCKING IN UNIT TESTS
For example, It is not possible to calculate the rent of a book unless the book is already rented
Mocking allows to override certain value/methods
dependency added to pom.xml and used annotation @ExtendWith on our test class which enables us to usmocking methods
STATIC METHODS CANNOT BE MOCKED
The scope of the mock is only within the method that is called. Thus, this option is correct.
The getRentedDate() method will return fourDaysBeforeToday only inside the calculateBookRent_should_return_2_dollars_if_number_of_days_is_4() test.
// Assertion to Verify if getRentedDate is called inside calculateBookRent
Mockito.verify(rentedBook).getRentedDate();



