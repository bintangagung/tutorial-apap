import React , { Component } from 'react' ;
import Layout from './components/Layout/Layout' ;
import Restorans from './containers/Restorans/Restorans' ;

class App extends Component {
  render (){
      return (
        < React.Fragment >
        < Layout >
          {/* < p > Hello, World! </ p > */}
          < Restorans />
        </ Layout >
      </ React.Fragment >
      );
  }
}

export default App ;