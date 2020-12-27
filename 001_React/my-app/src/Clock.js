import React from 'react';
class Clock extends React.Component {
    constructor(props) {
      super(props);
      this.state = {date : new Date().toUTCString()};
    }
    componentDidMount() {
        this.timer = setInterval(
            () => this.tick(),1000);
      }
      
    componentWillUnmount() {
    clearInterval(this.timer);
    }

    tick() {
    this.setState({
        date: new Date().toUTCString()
    });
    }

    render() {
        return(
            <span>UTC Time is: {this.state.date}</span>
        )
    }
}
export default Clock;
