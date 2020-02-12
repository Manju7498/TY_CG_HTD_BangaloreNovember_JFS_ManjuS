package com.capgemini.forestrymanagementcucumber.runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = ".//Feature",glue = {"com.capgemini.loanprocessingsystemcucumber.stepdefinition"})
public class Runner {

}
