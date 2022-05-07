package net.javaguide.springboot.model;

//Use lombok boilerplate codes

import lombok.*;

import javax.persistence.*;

//@Data :- this internally provides so many things like toString(), hashCode(), equals().
//When you do not need all these methods you can simply use @Getter and @Setter .
@Getter // Create a get methods for these private keys
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")// If you need you can specify schema and other details.
public class Employee {
//    Creating local variables
    @Id // make a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key generating strategy.
    private long id; // This is the primary key for the table
    @Column(name = "first_name")
    private  String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String emailId;
}
