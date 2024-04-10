package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Meetings")
public class Meetings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMeet;

    @ManyToOne
    @JoinColumn(name = "userIdschedule")
    private User idUserSchedule;

    @ManyToOne
    @JoinColumn(name = "coachId")
    private User idCoach;

    

}
