// change array here
import Ember from 'ember';

export default Ember.Route.extend({
	model () {
		let reportViewArray = [
			{
				number: "1",
				group: "Alpha",
				pupType: "Conference Paper",
				ProgStat: "60%",
				state: "inProgress",
				dueDate: "24/04/16"
			}, {
				number: "2",
				group: "Olmega",
				pupType: "Journal",
				ProgStat: "30%",
				state: "inProgress",
				dueDate: "01/04/16"
			}, {
				number: "3",
				group: "Bravo",
				pupType: "Book",
				ProgStat: "90%",
				state: "inProgress",
				dueDate: "31/03/16"
			}
		];
		return reportViewArray;
	}
});
