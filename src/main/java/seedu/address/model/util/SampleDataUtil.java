package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.FinancialDatabase;
import seedu.address.model.ReadOnlyFinancialDatabase;
import seedu.address.model.person.*;
import seedu.address.model.transaction.Amount;
import seedu.address.model.transaction.PersonId;
import seedu.address.model.transaction.Transaction;
import seedu.address.model.transaction.Type;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[]{
                new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                        new Address("Blk 30 Geylang Street 29, #06-40"), new UniqueId("1"),
                        getTagSet("friends")),
                new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new UniqueId("2"),
                        getTagSet("colleagues", "friends")),
                new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                        new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new UniqueId("3"),
                        getTagSet("neighbours")),
                new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new UniqueId("4"),
                        getTagSet("family")),
                new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                        new Address("Blk 47 Tampines Street 20, #17-35"), new UniqueId("5"),
                        getTagSet("classmates")),
                new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                        new Address("Blk 45 Aljunied Street 85, #11-31"), new UniqueId("6"),
                        getTagSet("colleagues"))
        };
    }

    public static Transaction[] getSampleTransactions() {
        return new Transaction[]{
                new Transaction(new Type("debt"), new Amount("SGD33"), new PersonId("1")),
                new Transaction(new Type("loan"), new Amount("SGD55"), new PersonId("2"))
        };
    }

    public static ReadOnlyFinancialDatabase getSampleFinancialDatabase() {
        FinancialDatabase sampleFd = new FinancialDatabase();
        for (Person samplePerson : getSamplePersons()) {
            sampleFd.addPerson(samplePerson);
        }
        for (Transaction sampleTransaction : getSampleTransactions()){
            sampleFd.addTransaction(sampleTransaction);
        }
        return sampleFd;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
