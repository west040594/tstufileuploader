<template>
    <div>
        <file-upload :url='url' :thumb-url='thumbUrl' :headers="headers" @change="onFileChange"></file-upload>
    </div>
</template>

<script>
    import FileUpload from 'v-file-upload'

    export default {
        name: "SenderApp",
        components: {FileUpload},
        data() {
          return {
            url: 'http://0.0.0.0:8081/uploadFile',
            headers: {'access-token': '<your-token>'},
            filesUploaded: []
          }
        },
        methods: {
          thumbUrl (file) {
            return file.myThumbUrlProperty
          },
          onFileChange (file) {
            // Handle files like:
            this.fileUploaded = file
          }
        }
    }
</script>
