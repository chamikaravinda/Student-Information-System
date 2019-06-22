import React, { Component } from 'react';


export default class Login extends Component {

    componentDidMount(){
        if(!sessionStorage.getItem('isloged')){
            this.props.history.push('/login');
        }else {
            this.props.history.push('/courseList');
        }
    }

    render() {
        return (
            <div >
                <h3>Welcome to SLIIT</h3>
            </div>
        )
    }

}