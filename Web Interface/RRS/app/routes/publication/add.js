//find out why its not working?
import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        let addPArray = [
                {
                names: [
                { 
                    state: "inProgress",
                }, { 
                    state: "Submitted",
                }, { 
                    state: "Accepted",
                }, { 
                     state: "InRevision",
                }, {
                    state: "Abandoned",
                }],
                states: [
                { 
                    state: "inProgress",
                }, { 
                    state: "Submitted",
                }, { 
                    state: "Accepted",
                }, { 
                     state: "InRevision",
                }, {
                    state: "Abandoned",
                }],
            }];
        return addPArray;
  }

});
