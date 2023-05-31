import logo from './logo.svg';
import './App.css';
import { Component } from 'react';


class NoteList extends Component {

  constructor(props) {
    super(props);
    this.state = {notes: []};
  }

  componentDidMount() {
    var response = fetch('/notes')
    .then(response => response.json())
    .then(data => this.setState({notes: data}));
  }

  render() {
    const {notes} = this.state;
    console.log(this.state)
    return (
      <div>
        <h2>Todo List</h2>
        {notes.map(note =>
                  <div key={note.id}>
                    {note.title}: ({note.content})
                  </div>
              )}
      </div>
    );
  }
}



export default function App() {

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <div className="App-intro">
              <NoteList />
            </div>
      </header>
    </div>
  );
}

