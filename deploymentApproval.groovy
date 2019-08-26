def call(String environment, List<String> approvers, String inputQuestion) {
    return input(
            id: "userInput${environment}",
            message: "Deploy to ${environment}",
            parameters: [string(defaultValue: '', description: "Enter 'yes' to deploy to ${environment}", name: "${inputQuestion}")],
            submitterParameter: 'submitter',
            submitter: approvers.join(',')
    )
}