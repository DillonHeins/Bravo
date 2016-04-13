import Ember from 'ember';

export default Ember.Route.extend({
model () {
        let pubViewArray = [
            {
                number: "1",
                title: "Theory of Teaching Computer Science",
                group: "Alpha",
                author: "Linda Marshall, Vreda Pieterse",
                pupType: "Conference Paper",
                ProgStat: 100,
                state: "In Progress",
                dueDate: "24/04/16"
            }, {
                number: "2",
                title: "Something to do with AI",
                group: "Olmega",
                author: "Andries Engelbrecht",
                pupType: "Journal",
                ProgStat: 30,
                state: "In Progress",
                dueDate: "01/04/16"
            }
        ];
        return pubViewArray;
    }

});
