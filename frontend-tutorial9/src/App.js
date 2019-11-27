import React , { Component } from 'react' ;
import Layout from './components/Layout/Layout' ;
import Restorans from './containers/Restorans/Restorans' ;

class App extends Component {
  render (){
      return (
        < div >
        < Layout >
          {/* < p > Hello, World! </ p > */}
          < Restorans />
        </ Layout >
      </ div >
      );
  }
}

export default App ;