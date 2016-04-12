package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inprogressstate database table.
 * 
 */
@Entity
@NamedQuery(name="Inprogressstate.findAll", query="SELECT i FROM Inprogressstate i")
public class Inprogressstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int inProgressID;

	private int percentageComplete;

	//bi-directional many-to-one association to Lifecyclestate
	@OneToMany(mappedBy="inprogressstate")
	private List<Lifecyclestate> lifecyclestates;

	public Inprogressstate() {
	}

	public int getInProgressID() {
		return this.inProgressID;
	}

	public void setInProgressID(int inProgressID) {
		this.inProgressID = inProgressID;
	}

	public int getPercentageComplete() {
		return this.percentageComplete;
	}

	public void setPercentageComplete(int percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public List<Lifecyclestate> getLifecyclestates() {
		return this.lifecyclestates;
	}

	public void setLifecyclestates(List<Lifecyclestate> lifecyclestates) {
		this.lifecyclestates = lifecyclestates;
	}

	public Lifecyclestate addLifecyclestate(Lifecyclestate lifecyclestate) {
		getLifecyclestates().add(lifecyclestate);
		lifecyclestate.setInprogressstate(this);

		return lifecyclestate;
	}

	public Lifecyclestate removeLifecyclestate(Lifecyclestate lifecyclestate) {
		getLifecyclestates().remove(lifecyclestate);
		lifecyclestate.setInprogressstate(null);

		return lifecyclestate;
	}

}