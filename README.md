# BrokenLinks
This repo for developing detection broken links tools in any websites, this tool crucial for QA works specially for those who work in government sectors. Personally I struggled with issue becasue in my current job I am working in government portal contain more than 600 pages, all the time there are broken links, which impossible to detected manually. Therefore, I built a complete automation framework, which can help broken links detection.


**How tool works**

The tool will scan any given websites link and detect HTTP response code who has status more than 400, which indication for broken links. Broken links in the HTTP is any code has status value more than 400, below are the HTTP codes status, which considered as a broken link :


![image](https://user-images.githubusercontent.com/73906550/194803893-95d5efbc-bd8f-469a-a57d-2bdf9e6ae889.png)


This services will be avalaible on Jenkins  untill allow anyone to run through mobile, desktop, which will easy to access.


**What is Jenkins**

Jenkins is an open-source automation tool written in Java with plugins built for Continuous Integration purposes. Below my site on Jenkins

![image](https://user-images.githubusercontent.com/73906550/194804658-2f8261f5-83b3-4b5a-9066-7144c2ac006a.png)


**Solution Architecture**

![image](https://user-images.githubusercontent.com/73906550/194813104-5b8dcb99-9af3-4387-9ede-6fc97d23035e.png)
