// import React from 'react';
// import ReactDOM from 'react-dom';
// import './index.css';
// // import App from './App';
// import AppFunc from "./AppFunc" ;
// import AppClass from "./App" ;
// import * as serviceWorker from './serviceWorker';

// ReactDOM.render(
// <>
//     <div className="mt-5" />
//     <AppClass />
//     <div className="mt-5 mb-5" />
//     <AppFunc />
//     <div className="mt-5 mb-5" />
// </>,
// // you should check public/index.html
// // there is a dom with id `root`
// document.getElementById("root")
// );

// // If you want your app to work offline and load faster, you can change
// // unregister() to register() below. Note this comes with some pitfalls.
// // Learn more about service workers: https://bit.ly/CRA-PWA
// serviceWorker.unregister();


// // latihan 14
// import React from 'react';
// import ReactDOM from 'react-dom';

// const green = '#39D1B4';
// const yellow = '#FFD712';

// class Toggle extends React.Component {
//   //give constructor here
//   constructor (props) {
//       super(props);
//       this.state = {color:green};
//       this.changeColor = this.changeColor.bind(this);
//   }
  
// //give changeColor here
// changeColor() {
//     this.setState({color:yellow});
// }

//   render() {
//     return (
//       <div style={{background:this.state.color}}>
//         <h1>
//           Change my color
//         </h1>
//         <button onClick={this.changeColor}>
//         Change Background
//         </button>
//       </div>
//     );
//   }
// }

// ReactDOM.render(<Toggle />, document.getElementById('root'));


// //Latihan 15
// import React from 'react';
// import ReactDOM from 'react-dom';
// import { Child } from './Child';

// class Parent extends React.Component {
//   constructor(props) {
//     super(props);

//     this.state = { name: 'Frarthur' };
//     this.changeName = this.changeName.bind(this);
//   }

//   changeName(newName) {
//       this.setState({name:newName});
//   }

//   render() {
//     return <Child name={this.state.name} onChange={this.changeName}/>
//   }
// }

// ReactDOM.render(
// 	<Parent />,
// 	document.getElementById('root')
// );



// Latihan input
import React from 'react';
import ReactDOM from 'react-dom';

export class Input extends React.Component {
    constructor(props) {
        super(props);
        this.state = {inputName :''}
        this.handleInput = this.handleInput.bind(this); //harus selalu ada ya
    }

    handleInput (e) {
        const name = e.target.value;
        this.setState({inputName:name});
    }

  render() {
    return (
      <div>
        <input type="text" onChange={this.handleInput}/>
        <h1>I am annnnnn {this.state.inputName}.</h1>
      </div>
    );
  }
}

ReactDOM.render(
	<Input />,
	document.getElementById('root')
);