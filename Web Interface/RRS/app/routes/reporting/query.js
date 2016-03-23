import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        let reportQArray = [
            {
                states: [{ 
                        state: "inProgress"
                    }, { 
                        state: "Submitted"
                    }, { 
                        state: "Accepted"
                    }, { 
                        state: "InRevision"
                    }, {
                        state: "Abandoned"
                }]
            }
            
        ];
        return reportQArray;
  }
});
