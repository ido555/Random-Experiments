import Clock from './Clock';

function App() {
  let elements = [];
  for (let i = 0; i < 15; i++) {
    elements.push(
    <tr key={i}>
      {<td id={"name" + i}>Name {i}</td>}
      {<td>Last {i}</td>}
      {<td>Age {i+25}</td>}
      {<td><Clock /></td>}
    </tr>)
  }
  return (
    elements
  );
}
export default App;
