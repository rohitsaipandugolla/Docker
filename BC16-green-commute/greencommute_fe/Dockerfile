FROM node:10-alpine as builder
COPY package.json  ./
RUN npm install
RUN npm install react-scripts@3.0.1 -g
RUN mkdir /app && mv ./node_modules ./app
WORKDIR /app
COPY . .
RUN npm run build-dev




FROM nginx:alpine
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /app/dist /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]