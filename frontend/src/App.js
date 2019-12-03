import React from "react";
import EmptyState from "./components/EmptyState";
import List from "./components/List";
import dummyItems from "./items.json";

export default class App extends React.Component {
  constructor() {
    super();

    this.state = { checked: false };
    this.state = {
      favItems: []
    };
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange() {
    this.setState({
      checked: !this.state.checked
    })
  }

  handleItemClick = item => {
    // immutability
    const newItems = [...this.state.favItems];
    const newItem = { ...item };
    // find index of item with id
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    this.setState({ favItems: newItems });
  };

  handleFavItemClick = item => {
    // immutability
    const newItems = [...this.state.favItems];
    const newItem = { ...item };
    // find index of item with id
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    newItems.splice(targetInd, 1);
    this.setState({ favItems: newItems });
  };

  handleChange() {
    this.setState({
      checked: !this.state.checked
    })
  }

  
  handleTemaClick = item => {
      this.setState({
        background : "#333"
      })
  };

  handleChange() {
    this.setState({
      background : "#333",
    })
  }

  // for class based component, you need to provide render
  // function
  render() {
    const { favItems } = this.state;
    const content = 
    <div className="col-sm"> 
    <List
      title="My Favorite"
      items={favItems}
      onItemClick={this.handleFavItemClick}
      checkbox={true}
    /> 
    </div>
    
    const contentFav = this.state.checked ? favItems.length > 0 ? content :<EmptyState/> : null

    return (
      <div className="container-fluid">
        <h1 className="text-center">
          Welcome!
    <small>Class-based</small>
        </h1>
        <h4 onItemsClick={this.handleTemaClick} >change tema</h4>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="Our Menu"
                items={dummyItems}
                onItemClick={this.handleItemClick}
                checkbox={false}
              />
            </div>
            <div className="col-sm">
              <input
                type="checkbox"
                checked={ this.state.checked }
                onChange={this.handleChange} />
              {contentFav}
            </div>
          </div>
        </div>
      </div>
    );
  }
}
