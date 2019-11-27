import React , { Component } from 'react' ;
import classes from "./Restoran.module.css";

class Restorans extends Component {

    constructor(props){
        super(props);
        this.state = {
            restoran:
            [
                {id: 1, nama: "Restoran A", alamat: "This is Address Restoran A", nomorTelepon: "021735313"},
                {id: 1, nama: "Restoran B", alamat: "This is Address Restoran B", nomorTelepon: "021120491"},
                {id: 1, nama: "Restoran C", alamat: "This is Address Restoran C", nomorTelepon: "021940256"}
            ],
            isLoading: true,
        }
    }

    render (){
        return (
        < React.Fragment >
            <div className={classes.Title}> All Restorans </div>
            <div className={classes.Restorans}>
                {this.state.restorans.map(restoran =>
                    <Restoran 
                        key={restoran.id}
                        nama={restoran.nama}
                        alamat={restoran.alamat}
                        nomorTelepon={restoran.nomorTelepon}
                    />
                )}
            </div>
        </ React.Fragment >
        );
    }

    // componentDidMount() {
    //     console.log("componentDidMount()");
    // }

    // shouldComponentUpdate(nextProps, nextState) {
    //     console.log("shouldComponentUpdate()");
    //     return true; //ditambahin
    // }

    // loadingHandler = () => {
    //     const currentIsLoading = this.state.isLoading;
    //     this.setState({isLoading: !(currentIsLoading)} );
    //     console.log(this.state.isLoading);
    // }
    
    // render (){
    //     console.log("render()");
    //     return (
    //     < div >
    //         < div > Hello! Welcome to Gopud </ div >
    //         < div > All Restorans </ div >
    //         < div > Restorans 1, 2, 3, etc </ div >
    //         <button onClick={this.loadingHandler}>change State </button>
    //     </ div >
    //     );
    // }
}

export default Restorans ;