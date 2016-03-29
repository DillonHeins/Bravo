
import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        let todos = [
            {
                name: "Persons",
                url: "persons",
								sub: [{
									name: "Add",
	                url: "/add",
								}, {
									name: "Edit",
	                url: "/edit",
								},{
									name: "Add Research",
	                url: "/add-research",
								}],
            }
        ];
        return todos;
    }
});
