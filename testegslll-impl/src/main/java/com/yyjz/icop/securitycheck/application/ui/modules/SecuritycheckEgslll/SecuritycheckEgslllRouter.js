/**
 * Created by ICOP on 2019-04-09.
 */
var SecuritycheckEgslllListPage = require('./SecuritycheckEgslllListPage');
var SecuritycheckEgslllCardPage = require('./SecuritycheckEgslllCardPage');
var PageRoutes = require('./PageRoutes');

SecuritycheckEgslllRouter = (
    <Route path="securitycheckEgslll" component={PageRoutes}>
        <IndexRoute component={SecuritycheckEgslllListPage}/>
        <Route path="card" component={SecuritycheckEgslllCardPage}></Route>
    //分支一的代码
    </Route>
)