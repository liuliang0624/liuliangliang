/**
 * Created by ICOP on 2019-04-09.
 */
var TenderListPage = require('./TenderListPage');
var TenderCardPage = require('./TenderCardPage');
var PageRoutes = require('./PageRoutes');

TenderRouter = (
    <Route path="tender" component={PageRoutes}>
        <IndexRoute component={TenderListPage}/>
        <Route path="card" component={TenderCardPage}></Route>
    </Route>
)