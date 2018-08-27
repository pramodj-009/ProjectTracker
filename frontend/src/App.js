import React, { Component } from 'react';
import styled from 'styled-components';
import {Layout, Spin} from 'antd';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import routes from './routes';
import Header from './widgets/header';
import Footer from './widgets/footer';

const StyledContent = styled(Layout.Content)`
  display: flex;
  margin: auto;
  padding: 0 10px;
  max-width: 100%;
`;

class App extends Component {
  render() {
    return (
      <Router>
        <Layout>
          <Header />
          <StyledContent>
            <Switch>
              {Object.values(routes).map((route,index) => (
                <Route key={index}
                    path={route.path}
                    component={route.main} />
              ))}
            </Switch>
          </StyledContent>
          <Footer/>
        </Layout>
      </Router>
    );
  }
}

export default App;
