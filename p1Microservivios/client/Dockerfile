
FROM node:14-alpine

WORKDIR /app

COPY . /app/client

RUN npm install express

EXPOSE 80

CMD ["node", "client.js"]

